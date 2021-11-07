package com.hacknc;

public class PlantImpl implements Plant {
    private final String _name; // Name of plant
    private final Seed.Type _type; // Type of plant
    private final int _timeRipe; // The amount of time needed before a plant is ripe
    private final int _timeOverripe; // The amount of time needed before a plant is overripe
    private long _timePlanted; // The time that the plant is planted according to delta time
    private GrowthStage _growthStage;
    private int _yield; // Yield of the plant (the cost of the plant harvest)
    private final long _nutrientIn; // Nutrients that are removed from the tile class every tick
    private long _malTime; // Time of malnourishment

    public PlantImpl(
            String name, Seed.Type type, int timeRipe, int timeOverripe, int yield, long nutrientIn) {
        _name = name;
        _type = type;
        _timeRipe = timeRipe;
        _timeOverripe = timeOverripe;
        _timePlanted = 0;
        _growthStage = GrowthStage.UNPLANTED;
        _yield = yield;
        _nutrientIn = nutrientIn;
        _malTime = 0;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Seed.Type getType() {
        return _type;
    }

    @Override
    public int getRipe() {
        return _timeRipe;
    }

    @Override
    public int getOverRipe() {
        return _timeOverripe;
    }

    @Override
    public long getTimePlanted() {
        return _timePlanted;
    }

    @Override
    public int getYield() {
        return (int) (_yield * (_malTime / _timePlanted));
    }

    @Override
    public int setYield(int amount) {
        _yield = amount;
        return amount;
    }

    @Override
    public long getNutrientIn() {
        return _nutrientIn;
    }

    @Override
    public GrowthStage getGrowthStage() {
        GrowthStage res = GrowthStage.UNPLANTED;
        if (_timePlanted < _timeRipe && _timePlanted > 0) {
            res = GrowthStage.PREMATURE;
        } else if (_timeRipe < _timePlanted && _timePlanted < _timeOverripe) {
            res = GrowthStage.RIPE;
        } else if (_timeRipe > _timeOverripe) {
            res = GrowthStage.OVERRIPE;
        }
        return res;
    }

    @Override
    public long update(long delta, long nutri) {
        _timePlanted += delta;
        if (nutri < _nutrientIn * delta) {
            _malTime += (1 - nutri / (_nutrientIn * delta)) * delta;
        }
        return delta;
    }
}
