package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Database control for regions.
 */
public class RegionDB {

    public static void addRegion(Region region) {
        region.save();
    }

    /**
     * Get all the regions.
     * @return The list of regions.
     */
    public static List<Region> getRegions() {
        return Region.find().all();
    }

    /**
     * Find a list of regions.
     * @param region The region string.
     * @return
     */
    public static List<String> getZipCodesFromRegion(String region) {
        List<Region> regions = Region.find().where().contains("regions", region).findList();
        List<String> zipCodes = new ArrayList<>();
        for (Region r : regions) {
            zipCodes.add(r.getZipCode());
        }

        return zipCodes;
    }
}
