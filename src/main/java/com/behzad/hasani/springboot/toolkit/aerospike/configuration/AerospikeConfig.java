package com.behzad.hasani.springboot.toolkit.aerospike.configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.policy.ClientPolicy;
import com.behzad.hasani.springboot.toolkit.aerospike.repositories.CacheNames;
import com.behzad.hasani.springboot.toolkit.aerospike.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.aerospike.cache.AerospikeCacheConfiguration;
import org.springframework.data.aerospike.cache.AerospikeCacheManager;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableAerospikeRepositories(basePackageClasses = EmployeeRepository.class)
@Import(CacheProperties.class)
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {

    @Value("${spring.aerospike.host}")
    private String host;

    @Value("${spring.aerospike.port}")
    private int port;

    @Bean(destroyMethod = "close")
    public AerospikeClient aerospikeClient() {
        ClientPolicy clientPolicy = new ClientPolicy();
        return new AerospikeClient(clientPolicy, host, port);
    }

    @Override
    protected Collection<Host> getHosts() {
        return Collections.singleton(new Host(host, port));
    }

    @Override
    protected String nameSpace() {
        return "test";
    }

    @Bean
    public CacheManager cacheManager(AerospikeClient aerospikeClient,MappingAerospikeConverter mappingAerospikeConverter) {
        Map<String,AerospikeCacheConfiguration> map = new HashMap<>();
        Set<String> cacheNames = Arrays.stream(CacheNames.values()).map(CacheNames::getName).collect(Collectors.toSet());

        for (String cacheName : cacheNames) {
            map.put(cacheName, new AerospikeCacheConfiguration(nameSpace(),cacheName));
        }

        return new AerospikeCacheManager(aerospikeClient, mappingAerospikeConverter, map.get(CacheNames.COMMON.getName()),map);
    }

}
