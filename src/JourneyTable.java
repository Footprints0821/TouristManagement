import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JourneyTable extends Table {
	//JourneyTable is a subclass of Table
	private static final long serialVersionUID = 2875684490806539721L;
	
	public ArrayList<Journey> journeyList = new ArrayList<Journey>();
	
	public TrainDatabase trainDatabase = null;

	public JourneyTable(TrainDatabase trainDatabase, String filePath, String... headers) {
		super(filePath, headers);
		this.trainDatabase = trainDatabase;
	}
	
	public String checkRDTData() {
	//Check validation of input, which need to follow the requirement
		for (int i = 0; i < this.getRowCount(); i++) {
			if (!this.trainDatabase.routeTable.hasValueInCol((String) this.getValueAt(i, 1), 0)) {
				return "Route \"" + this.getValueAt(i, 1) + "\" does't exist!";
			}
			if (!this.trainDatabase.trainTable.hasValueInCol((String) this.getValueAt(i, 2), 0)) {
				return "Train \"" + this.getValueAt(i, 2) + "\" does't exist!";
			}
			if (!this.trainDatabase.driverTable.hasValueInCol((String) this.getValueAt(i, 3), 0)) {
				return "Driver \"" + this.getValueAt(i, 3) + "\" does't exist!";
			}
		}
		
		return null;
	}

	public String checkData(List<String> journeys) {
	//Check the data format including the time arrangement and train/driver arrangement
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		for (int i = 4; i < journeys.size(); i++) {
			try {
				sdf.parse(journeys.get(i));
			} catch (ParseException e) {
				return "Time \"" + journeys.get(i) + "\" is illegal!";
			}
		}

		try {
			Date startDate = sdf.parse(journeys.get(4));

			if (!(startDate.after(sdf.parse("07:59")) && startDate.before(sdf.parse("16:01")))) {
				return "Illegal time: \"" + journeys.get(4) + "\". Start time must between 08:00 and 16:00!";
			}

			for (int i = 5; i < journeys.size(); i++) {
				long deltaTime = sdf.parse(journeys.get(i)).getTime() - sdf.parse(journeys.get(i - 1)).getTime();
				if (!(deltaTime >= 15 * 60 * 1000 && deltaTime <= 30 * 60 * 1000)) {
					return "Illegal time: \"" + journeys.get(i) + "\". Time used between two stops must between 15min and 30min!";
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < this.getRowCount() - 1; i++) {
			for (int j = i + 1; j < this.getRowCount(); j++) {
				if (this.getValueAt(i, 2).equals(this.getValueAt(j, 2))) {
					return "Journey \"" + this.getValueAt(i, 0) + "\" and Journey \"" + this.getValueAt(j, 0) + "\" use same Train \""
							+ this.getValueAt(i, 2) + "\"!";
				}
				if (this.getValueAt(i, 3).equals(this.getValueAt(j, 3))) {
					return "Journey \"" + this.getValueAt(i, 0) + "\" and Journey \"" + this.getValueAt(j, 0) + "\" use same driver \""
							+ this.getValueAt(i, 3) + "\"!";
				}
			}
		}

		// return "Journey \"" + journeys.get(0) + "\" has illegal time schedule!";

		return null;
	}
	
	public List<List<String>> getJourney(List<String> routes) {
		ArrayList<List<String>> res = new ArrayList<List<String>>();
		
		for (int i = 0; i < routes.size(); i++) {
			for (int j = 0; j < this.getRowCount(); j++) {
				if (routes.get(i).equals(this.getValueAt(j, 1))) {
					res.add(this.allData.get(j + 1));
				}
			}
		}
		
		return res;
	}

	public String checkIsValid() {
	//Validation checking contained more requirement
		String checkRes = super.checkIsValid();

		if (checkRes != null) {
			return checkRes;
		} else {
			checkRes = this.checkRDTData();
			if (checkRes != null) {
				return checkRes;
			}
			
			for (int i = 0; i < this.getRowCount(); i++) {
				checkRes = checkData(this.allData.get(i + 1));
				if (checkRes != null) {
					return checkRes;
				}
			}

			return null;
		}
	}
}
