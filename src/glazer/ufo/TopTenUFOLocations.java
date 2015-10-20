package glazer.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class TopTenUFOLocations {

	public static void main(String args[]) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		int highest1 = 0;
		int highest2 = 0;
		int highest3 = 0;
		int highest4 = 0;
		int highest5 = 0;
		int highest6 = 0;
		int highest7 = 0;
		int highest8 = 0;
		int highest9 = 0;
		int highest10 = 0;
		String sighting1 = null;
		String sighting2 = null;
		String sighting3 = null;
		String sighting4 = null;
		String sighting5 = null;
		String sighting6 = null;
		String sighting7 = null;
		String sighting8 = null;
		String sighting9 = null;
		String sighting10 = null;
		for (Entry<String, Integer> entry : locations.entrySet()) {
			if (entry.getValue().compareTo(highest1) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = highest5;
				sighting6 = sighting5;
				highest5 = highest4;
				sighting5 = sighting4;
				highest4 = highest3;
				sighting4 = sighting3;
				highest3 = highest2;
				sighting3 = sighting2;
				highest2 = highest1;
				sighting2 = sighting1;
				highest1 = entry.getValue();
				sighting1 = entry.getKey();
			} else if (entry.getValue().compareTo(highest2) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = highest5;
				sighting6 = sighting5;
				highest5 = highest4;
				sighting5 = sighting4;
				highest4 = highest3;
				sighting4 = sighting3;
				highest3 = highest2;
				sighting3 = sighting2;
				highest2 = entry.getValue();
				sighting2 = entry.getKey();
			} else if (entry.getValue().compareTo(highest3) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = highest5;
				sighting6 = sighting5;
				highest5 = highest4;
				sighting5 = sighting4;
				highest4 = highest3;
				sighting4 = sighting3;
				highest3 = entry.getValue();
				sighting3 = entry.getKey();
			} else if (entry.getValue().compareTo(highest4) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = highest5;
				sighting6 = sighting5;
				highest5 = highest4;
				sighting5 = sighting4;
				highest4 = entry.getValue();
				sighting4 = entry.getKey();
			} else if (entry.getValue().compareTo(highest5) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = highest5;
				sighting6 = sighting5;
				highest5 = entry.getValue();
				sighting5 = entry.getKey();

			} else if (entry.getValue().compareTo(highest6) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = highest6;
				sighting7 = sighting6;
				highest6 = entry.getValue();
				sighting6 = entry.getKey();
			} else if (entry.getValue().compareTo(highest7) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = highest7;
				sighting8 = sighting7;
				highest7 = entry.getValue();
				sighting7 = entry.getKey();
			} else if (entry.getValue().compareTo(highest8) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = highest8;
				sighting9 = sighting8;
				highest8 = entry.getValue();
				sighting8 = entry.getKey();
			} else if (entry.getValue().compareTo(highest9) > 0) {
				highest10 = highest9;
				sighting10 = sighting9;
				highest9 = entry.getValue();
				sighting9 = entry.getKey();
			} else if (entry.getValue().compareTo(highest10) > 0) {
				highest10 = entry.getValue();
				sighting10 = entry.getKey();
			}
		}
		StringBuilder builder = new StringBuilder();
		builder.append(sighting1);
		builder.append(" had ");
		builder.append(highest1);
		builder.append(" sightings.\n");
		builder.append(sighting2);
		builder.append(" had ");
		builder.append(highest2);
		builder.append(" sightings.\n");
		builder.append(sighting3);
		builder.append(" had ");
		builder.append(highest3);
		builder.append(" sightings.\n");
		builder.append(sighting4);
		builder.append(" had ");
		builder.append(highest4);
		builder.append(" sightings.\n");
		builder.append(sighting5);
		builder.append(" had ");
		builder.append(highest5);
		builder.append(" sightings.\n");
		builder.append(sighting6);
		builder.append(" had ");
		builder.append(highest6);
		builder.append(" sightings.\n");
		builder.append(sighting7);
		builder.append(" had ");
		builder.append(highest7);
		builder.append(" sightings.\n");
		builder.append(sighting8);
		builder.append(" had ");
		builder.append(highest8);
		builder.append(" sightings.\n");
		builder.append(sighting9);
		builder.append(" had ");
		builder.append(highest9);
		builder.append(" sightings.\n");
		builder.append(sighting10);
		builder.append(" had ");
		builder.append(highest10);
		builder.append(" sightings.\n");

		System.out.println(builder.toString());
	}
}
