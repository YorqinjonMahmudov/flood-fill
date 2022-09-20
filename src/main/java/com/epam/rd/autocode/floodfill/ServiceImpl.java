package com.epam.rd.autocode.floodfill;

import java.util.HashMap;
import java.util.HashSet;

public class ServiceImpl implements FloodFill {

    @Override
    public void flood(String map, FloodLogger logger) {

        logger.log(map);
        if (map.indexOf(LAND) < 0) {
            return;
        }

        int n = map.indexOf('\n')+1 ;
        HashSet<Integer> nums = new HashSet<>();


        for (int i = 0; i < map.length(); i++) {
            if (map.charAt(i) == LAND) {
                if (i != 0 && map.charAt(i - 1) == WATER)
                    nums.add(i);
                else if (i != map.length() - 1 && map.charAt(i + 1) == WATER)
                    nums.add(i);
                else if (i - n >= 0 && map.charAt(i - n) == WATER)
                    nums.add(i);
                else if (i + n < map.length() && map.charAt(i + n) == WATER)
                    nums.add(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < map.length(); i++) {
            if (map.charAt(i) == LAND && nums.contains(i))
                stringBuilder.append(WATER);
            else
                stringBuilder.append(map.charAt(i));
        }


            flood(stringBuilder.toString(), logger);

    }
}
