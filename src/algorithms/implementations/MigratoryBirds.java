package algorithms.implementations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MigratoryBirds {

	
	// Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int id = 0;
        //create map of sightings
        Map<Integer, Long> sightings = arr.stream()
                                            .collect(
                                                Collectors.groupingBy(
                                                    Function.identity(),
                                                    Collectors.counting()
                                                )
                                            );
        //Get maximum count
        Long max = sightings.values().stream().max(Comparator.naturalOrder()).get();
        //Get smallest value from all the keys where value is max
        id = Collections.min(sightings.entrySet().stream().filter(e -> e.getValue()==max)
            .map(Map.Entry::getKey).collect(Collectors.toList()));
        return id;
    }

	
}
