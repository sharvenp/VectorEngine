package app.assets.levels;

import app.engine.core.components.Level;

public class Level0 extends Level {

    public Level0() {
        mapWidth = 15;
        mapHeight = 15;
        map = new int[][]
        {
                {1,1,1,1,1,1,1,1,2,2,2,2,2,2,2},
                {1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
                {1,0,2,2,2,2,2,0,0,0,0,0,0,0,2},
                {1,0,2,0,0,0,2,0,2,0,0,0,0,0,2},
                {1,0,2,0,0,0,2,0,2,2,2,0,2,2,2},
                {1,0,2,0,0,0,2,0,2,0,0,0,0,0,2},
                {1,0,2,2,0,2,2,0,2,0,0,0,0,0,2},
                {1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
                {1,1,1,1,1,1,1,1,2,2,2,0,2,2,2},
                {1,0,0,0,0,0,1,2,0,0,0,0,0,0,2},
                {1,0,0,0,0,0,1,2,0,0,0,0,0,0,2},
                {1,0,0,2,0,0,1,2,0,2,2,2,2,0,2},
                {1,0,0,0,0,0,1,2,0,2,2,2,2,0,2},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
                {1,1,1,1,1,1,1,2,2,2,2,2,2,2,2}
        };
    }

}
