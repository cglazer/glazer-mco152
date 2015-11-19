package glazer.ups;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class UPSDatabaseTest {

	@Test
	/** 
	 * Add a Package to a Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 */
	public void testAddPackageToLocation() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("123");
		Location location = new Location(3, 3);
		database.addPackageToLocation(location, pkg);
		HashSet<Package> set = new HashSet<Package>();
		set.add(pkg);
		Assert.assertEquals(set, database.getPackages(location));
		Assert.assertEquals(location, database.getLocation(pkg));
	}

	@Test
	/** 
	 * Add a Package to a Location then update the Package Location to a different Location. 
	 * Verify that the Package is returned with getPackages().
	 * Verify that the Location is returned with getLocation().
	 * Verify that the Package is NOT returned when calling getPackage() with the first Location.
	 */
	public void testUpdatePackageLocation() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("123");
		Location location = new Location(3, 3);
		database.addPackageToLocation(location, pkg);
		Location location2 = new Location(4, 4);
		database.updatePackageLocation(pkg, location2);
		HashSet<Package> set = new HashSet<Package>();
		Assert.assertEquals(set, database.getPackages(location));
		set.add(pkg);
		Assert.assertEquals(set, database.getPackages(location2));
		Assert.assertEquals(location2, database.getLocation(pkg));

	}

	@Test
	/**
	 * Verify that calling getPackages() returns an empty Set when called with
	 * a Location without Packages.
	 */
	public void testGetPackagesReturnsAnEmptySet() {
		UPSDatabase database = new UPSDatabase();
		Location location = new Location(3, 3);
		HashSet<Package> set = new HashSet<Package>();
		Assert.assertEquals(set, database.getPackages(location));
	}

	@Test
	/**
	 * Verify that calling getLocation() on an unknown Package returns null.
	 */
	public void testGetLocationReturnsNull() {
		UPSDatabase database = new UPSDatabase();
		Package pkg = new Package("123");
		Assert.assertEquals(null, database.getLocation(pkg));
	}

}
