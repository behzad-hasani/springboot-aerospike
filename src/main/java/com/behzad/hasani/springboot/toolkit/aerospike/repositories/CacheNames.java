package com.behzad.hasani.springboot.toolkit.aerospike.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CacheNames {
        COMMON ("common"),
        USER_SET1 ("user-set1"),
        USER_SET2 ("user-set2"),
        USER_SET3 ("user-set3");

    private final String name;

}
