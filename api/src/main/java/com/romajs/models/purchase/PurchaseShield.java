package com.romajs.models.purchase;

import io.yawp.repository.shields.Shield;

public class PurchaseShield extends Shield<Purchase> {

    @Override
    public void defaults() {
        // TODO Auto-generated method stub
        allow();
    }

}
