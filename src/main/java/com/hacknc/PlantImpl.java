package com.hacknc;

public class PlantImpl implements Plant {
    private final String _name; // Name of plant
    private final Seed.Type _type; // Type of plant
    private final int _timeRipe; // The amount of time needed before a plant is ripe
    private final int _timeOverripe; // The amount of time needed before a plant is overripe
    private double _timePlanted; // The time that the plant is planted according to delta time
    private GrowthStage _growthStage;
    private int _yield; // Yield of the plant (the cost of the plant harvest)
    private final double _nutrientIn; // Nutrients that are removed from the tile class every tick
    private double _malTime; // Time of malnourishment

    public PlantImpl(
            String name, Seed.Type type, int timeRipe, int timeOverripe, int yield, double nutrientIn) {
        _name = name;
        _type = type;
        _timeRipe = timeRipe;
        _timeOverripe = timeOverripe;
        _timePlanted = (double)0.0000001;
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
    public double getTimePlanted() {
        return _timePlanted;
    }

    @Override
    public int getYield() {
        return (int) (_yield);
    }

    @Override
    public int setYield(int amount) {
        _yield = amount;
        return amount;
    }

    @Override
    public double getNutrientIn() {
        return _nutrientIn;
    }

    @Override
    public GrowthStage getGrowthStage() {
        if (_timePlanted < _timeRipe && _timePlanted > 0) {
            _growthStage = GrowthStage.PREMATURE;
        } else if (_timeRipe < _timePlanted && _timePlanted < _timeOverripe) {
            _growthStage = GrowthStage.RIPE;
        } else if (_timePlanted > _timeOverripe) {
            _growthStage = GrowthStage.OVERRIPE;
        }
        return _growthStage;
    }

    @Override
    public double update(double delta, double nutri) {
        _timePlanted += delta;
        getGrowthStage();
        if (nutri < _nutrientIn * delta) {
            _malTime += (1 - nutri / (_nutrientIn * delta)) * delta;
        }
        return delta;
    }
}
