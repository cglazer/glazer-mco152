package glazer.ups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * REQUIREMENT: You may not use an ArrayList (or any "List") in this class.
 */
public class UPSDatabase {
	HashMap<Package, Location> map;
	HashMap<Location, HashSet<Package>> locationMap;

	public UPSDatabase() {
		map = new HashMap<Package, Location>();
		locationMap = new HashMap<Location, HashSet<Package>>();
	}

	/**
	 * Add a package to the specified Location
	 */
	public void addPackageToLocation(Location location, Package pkg) {
		map.put(pkg, location);

		if (!locationMap.containsKey(location)) {
			HashSet<Package> lset = new HashSet<Package>();
			lset.add(pkg);
			locationMap.put(location, lset);
		} else {
			HashSet<Package> lset = locationMap.get(location);
			lset.add(pkg);
			locationMap.put(location, lset);
		}
	}

	/**
	 * Update a Package's Location.
	 */
	public void updatePackageLocation(Package pkg, Location location) {
		Location location2 = map.get(pkg);
		HashSet<Package> pset = locationMap.get(location2);
		pset.remove(pkg);
		locationMap.put(location2, pset);
		map.put(pkg, location);
		if (!locationMap.containsKey(location)) {
			HashSet<Package> lset = new HashSet<Package>();
			lset.add(pkg);
			locationMap.put(location, lset);
		} else {
			HashSet<Package> lset = locationMap.get(location);
			lset.add(pkg);
			locationMap.put(location, lset);
		}
	}

	/**
	 * @return a Set of Packages at the specified Location or an empty Set if
	 *         the Location doesn't exist or there are no Packages at that
	 *         Location.
	 */
	public Set<Package> getPackages(Location location) {
		if (locationMap.containsKey(location)) {
			return locationMap.get(location);
		} else {
			HashSet<Package> set = new HashSet<Package>();
			return set;
		}
	}

	/**
	 * @return the Location of a Package or null if the Package doesn't exist.
	 */
	public Location getLocation(Package pkg) {
		return map.get(pkg);
	}
}
