/*
Flyweight Desing Pattern is a structural pattern that focuses on efficiently
sharing common parts of object state across many objects to reduce memory
usage and boost performance

The Flyweight Pattern minimizes memory usage by sharing as much data as
possible between similar objects.

Components :
FLyWeightFacroty - Cache : Flyweight
FLywieght interface : Dec;are a method that takes extrincin state
COncrete Flyweight : Im[lement Flyweight and strore intrinsic state
 */

import java.util.HashMap;
import java.util.Map;

interface FlyWeight {
    void draw(int x,int y);
}

class Concreteflyweight implements FlyWeight{
    private final char symbol;
    private final String font;
    private final int color;

    public Concreteflyweight(char symbol,String font,int color){
        this.color = color;
        this.font = font;
        this.symbol = symbol;
    }

    @Override
    public void draw(int x,int y) {
        cout<<"x and y";
    }
}

class FlyWeightFactory {
    private final Map<String,FlyWeight> m = new HashMap<>();
    public FlyWeight getFlyweight(char symbol, String font, int color) {
        String key = symbol + font + color;
        m.putIfAbsent(key, new Concreteflyweight(symbol, font, color));
        return m.get(key);
    }

    public int getFlyweightCount() {
        return m.size();
    }
}


public class FlyWeight {
}
