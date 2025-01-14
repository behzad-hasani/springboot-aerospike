package com.behzad.hasani.springboot.toolkit.aerospike.entities;

import lombok.*;
import org.springframework.data.aerospike.annotation.Indexed;
import org.springframework.data.aerospike.mapping.Field;
import org.springframework.data.annotation.Id;

import static com.aerospike.client.query.IndexCollectionType.DEFAULT;
import static com.aerospike.client.query.IndexType.STRING;

@Setter
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    private String id;
    @Indexed(type = STRING, collectionType = DEFAULT)
    @Field("first")
    private String firstName;
    @Indexed(type = STRING, collectionType = DEFAULT)
    @Field("last")
    private String lastName;
}
