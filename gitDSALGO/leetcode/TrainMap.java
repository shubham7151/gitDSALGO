package gitDSALGO.leetcode;

import java.util.stream.Collectors;
import java.util.*;

import gitDSALGO.leetcode.Station;;

public class TrainMap {
    

    private HashMap<String, Station> stations;

    TrainMap() {
        this.stations = new HashMap<>();
    }

    TrainMap addStation(String name) {
        Station s = new Station(name);
        this.stations.putIfAbsent(name, s);
        return this;
    }

    Station getStation(String name) {
        return this.stations.get(name);
    }

    TrainMap connectStations(Station fromStation, Station toStation) {
        if (fromStation == null) throw new IllegalArgumentException("From station is null");
        if (toStation == null) throw new IllegalArgumentException("From station is null");

        fromStation.addNeighbour(toStation);
        toStation.addNeighbour(fromStation);
        return this;
    }

    List<Station> shortestPath(final String from, final String to) {
    	Queue<Station> q = new LinkedList<>();
        HashMap<Station, Station> parentStation = new HashMap<>();

        //get both station
        Station  start = getStation(from);
        Station end = getStation(to);

        q.add(start);
        parentStation.put(start, null);

        while(!q.isEmpty()){
            Station curr = q.poll();

            if(curr.equals(end)){
                break;
            }

            for(Station xyz : curr.getNeighbours()){
                if(!parentStation.containsKey(xyz)){
                    q.add(xyz);
                    parentStation.put(xyz, curr);
                }
            }
        }

        List<Station> output = new ArrayList<>();
        Station curr = end;
        while(curr!=null){
            output.add(curr);
            curr= parentStation.get(curr);
        }

        Collections.reverse(output);
        return output;
    }
   
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }


    private static boolean doTestsPass() {
    // todo: implement more tests, please
    // feel free to make testing more elegant
    TrainMap trainMap = new TrainMap();

    trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
            .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
            .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

    trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
            .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
            .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
            .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
            .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
            .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
            .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
            .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

    String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
    List<Station> result = trainMap.shortestPath("King's Cross St Pancras", "St Paul's");
    return solution.equals(result.stream().map(Station::getName).collect(Collectors.joining("->")));
    }
}
