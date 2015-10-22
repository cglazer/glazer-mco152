package glazer.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.google.gson.Gson;

public class TopTenUFOLocations {

	public static void main(String args[]) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		}
		Gson gson = new Gson();
		// this will return for us a list of ufo sightings
		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);

		HashMap<String, Integer> locations = new HashMap<String, Integer>();
		for (int x = 0; x < list.size(); x++) {
			String location = list.get(x).getLocation();
			if (locations.containsKey(location)) {
				int value = locations.get(location);
				locations.put(list.get(x).getLocation(), value + 1);
			} else {
				locations.put(list.get(x).getLocation(), 1);
			}
		}
		ArrayList<String> array = new ArrayList<String>(locations.keySet());

		Collections.sort(array, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return locations.get(b).compareTo(locations.get(a));
			}
		});
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			builder.append(array.get(i));
			builder.append(" had ");
			builder.append(locations.get(array.get(i)));
			builder.append(" sightings. \n");
		}
		System.out.println(builder.toString());

	}
}