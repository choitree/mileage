package com.triple.mileage.domain;

import lombok.Getter;

@Getter
public enum Action {

    ADD("post"), MOD("put"), DELETE("delete");

    public String method;

    Action(String method) {
        this.method = method;
    }
}
