package com.tahanebti.crudrestapihateoasprojection.dto;

import com.tahanebti.crudrestapihateoasprojection.domain.User;

public interface UserProjection {

    User getUser();
    String getName();
}
