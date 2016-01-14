package glazer.contacts;

import java.util.Comparator;

public class NameComparator {
	public Comparator<Contacts> NAME = new Comparator<Contacts>() {

		@Override
		public int compare(Contacts arg0, Contacts arg1) {
			String[] fullname = arg0.getName().split(" ");
			String[] otherFullName = arg1.getName().split(" ");
			return fullname[1].compareTo(otherFullName[1]);

		}
	};
}
