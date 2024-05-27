package com.inventory.leonardo.inventory.exception;

public class ItemsNotFoundException extends RuntimeException {
    public ItemsNotFoundException(String message) {
        super(message);
    }
}
