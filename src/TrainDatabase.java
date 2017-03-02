import java.util.Arrays;


public class TrainDatabase {
	public String directoryPath = "";

	public Table trainTable = null;
	public Table driverTable = null;
	public RouteTable routeTable = null;
	public JourneyTable jouneryTable = null;

	public TrainDatabase(String directoryPath) {
		this.directoryPath = directoryPath;
		this.init();
	}

	public TrainDatabase() {
		this.init();
	}

	public void init() {
	//Initialize and load table
		this.trainTable = new Table(this.directoryPath + (this.directoryPath.equals("") ? "" : "\\") + "train_table.csv", "tid", "train name");
		this.driverTable = new Table(this.directoryPath + (this.directoryPath.equals("") ? "" : "\\") + "driver_table.csv", "did", "driver name");
		this.routeTable = new RouteTable(this.directoryPath + (this.directoryPath.equals("") ? "" : "\\") + "route_table.csv", "rid", "station 1",
				"station 2", "station 3", "station 4");
		this.jouneryTable = new JourneyTable(this, this.directoryPath + (this.directoryPath.equals("") ? "" : "\\") + "jounery_table.csv", "jid", "rid", "tid",
				"did", "time 0", "time 1", "time 2", "time 3", "time 4");
	}

	public void clear() {
	//Clear all the content in all table
		this.trainTable.clear();
		this.driverTable.clear();
		this.routeTable.clear();
		this.jouneryTable.clear();
	}

	public void load() {
	//Load the content of table to our system
		this.trainTable.load();
		this.driverTable.load();
		this.routeTable.load();
		this.jouneryTable.load();
	}

	public void save() {
	//Save the current value to table
		this.trainTable.save();
		this.driverTable.save();
		this.routeTable.save();
		this.jouneryTable.save();
	}

	public static void main(String[] args) {
	//Initialize some default data in the database
		TrainDatabase trainDatabase = new TrainDatabase();
		trainDatabase.clear();
		trainDatabase.trainTable.insertBack(Arrays.asList(new String[] { "#1001", "Freedom" }));
		trainDatabase.trainTable.insertBack(Arrays.asList(new String[] { "#1002", "Democracy" }));
		trainDatabase.trainTable.insertBack(Arrays.asList(new String[] { "#1003", "Queen" }));
		trainDatabase.trainTable.insertBack(Arrays.asList(new String[] { "#1004", "Prince" }));
		trainDatabase.trainTable.insertBack(Arrays.asList(new String[] { "#1005", "Secience" }));
		trainDatabase.driverTable.insertBack(Arrays.asList(new String[] { "#2001", "Tom" }));
		trainDatabase.driverTable.insertBack(Arrays.asList(new String[] { "#2002", "Mike" }));
		trainDatabase.driverTable.insertBack(Arrays.asList(new String[] { "#2003", "James" }));
		trainDatabase.driverTable.insertBack(Arrays.asList(new String[] { "#2004", "Andrew" }));
		trainDatabase.driverTable.insertBack(Arrays.asList(new String[] { "#2005", "Edison" }));
		trainDatabase.routeTable.insertBack(Arrays.asList(new String[] { "#3001", "A", "C", "E", "G" }));
		trainDatabase.routeTable.insertBack(Arrays.asList(new String[] { "#3002", "E", "D", "A", "C" }));
		trainDatabase.routeTable.insertBack(Arrays.asList(new String[] { "#3003", "D", "F", "B", "A" }));
		trainDatabase.routeTable.insertBack(Arrays.asList(new String[] { "#3004", "C", "A", "E", "B" }));
		trainDatabase.routeTable.insertBack(Arrays.asList(new String[] { "#3005", "B", "A", "G", "F" }));
		trainDatabase.jouneryTable.insertBack(Arrays.asList(new String[] { "#4001", "#3001", "#1001", "#2001", "08:00", "08:20", "08:40", "09:00", "09:20" }));
		trainDatabase.jouneryTable.insertBack(Arrays.asList(new String[] { "#4002", "#3002", "#1002", "#2002", "08:10", "08:30", "08:45", "09:05", "09:20" }));
		trainDatabase.jouneryTable.insertBack(Arrays.asList(new String[] { "#4003", "#3003", "#1003", "#2003", "09:00", "09:20", "09:40", "10:00", "10:20" }));
		trainDatabase.jouneryTable.insertBack(Arrays.asList(new String[] { "#4004", "#3004", "#1004", "#2004", "12:00", "12:20", "12:40", "13:00", "13:20" }));
		trainDatabase.jouneryTable.insertBack(Arrays.asList(new String[] { "#4005", "#3005", "#1005", "#2005", "13:00", "13:20", "13:40", "14:00", "15:20" }));
		System.out.println(trainDatabase.trainTable.dataToString());
		System.out.println(trainDatabase.driverTable.dataToString());
		System.out.println(trainDatabase.routeTable.dataToString());
		System.out.println(trainDatabase.jouneryTable.dataToString());

		trainDatabase.save();
	}
}