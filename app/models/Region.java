package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model for holding a specific region.
 */
@Entity
public class Region extends Model {
    /** The id. */
    @Id
    private long id;
    /** The name of the location. */
    private String areaName;
    /** The zip code for the region. */
    private String zipCode;
    /** Comma separated list of regions. */
    private String regions;

    /**
     * Public constructor to initialize new region.
     * @param areaName The name the town/area.
     * @param zipCode The zip code for the region.
     * @param regions The name used for the region. (eg. "South, Central")
     */
    public Region(String areaName, String zipCode, String regions) {
        this.areaName = areaName;
        this.zipCode = zipCode;
        this.regions = regions;
    }

    /**
     * The EBean ORM finder method for database queries.
     *
     * @return The finder method.
     */
    public static Finder<Long, Region> find() {
        return new Finder<Long, Region>(Long.class, Region.class);
    }

    /**
     * Get the id.
     * @return The id.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the id.
     * @param id The id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the area name.
     * @return The area name.
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Set the area name.
     * @param areaName The area name.
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * Get the zip code.
     * @return The zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set the zip code.
     * @param zipCode The zip code.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Get the regions.
     * @return The regions.
     */
    public String getRegions() {
        return regions;
    }

    /**
     * Set the regions.
     * @param regions The regions.
     */
    public void setRegions(String regions) {
        this.regions = regions;
    }
}
