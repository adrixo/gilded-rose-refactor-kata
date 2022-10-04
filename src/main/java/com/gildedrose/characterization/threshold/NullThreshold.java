package com.gildedrose.characterization.threshold;

public class NullThreshold  implements ThresholdI {
    public boolean belongs(int compared) {
        return true;
    }
}
