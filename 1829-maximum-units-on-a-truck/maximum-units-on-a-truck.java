class Solution {
    public class Pair implements Comparable<Pair>{
        int noOfBoxes;
        int units;
        Pair(int noOfBoxes,int units){
            this.noOfBoxes = noOfBoxes;
            this.units = units;
        }
        public int compareTo(Pair p){
            return p.units-this.units;
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Pair[] box = new Pair[boxTypes.length];
        for(int i=0;i<boxTypes.length;i++){
            box[i] = new Pair(boxTypes[i][0],boxTypes[i][1]);
        }
        Arrays.sort(box);
        int maxunits = 0;
        for (int i = 0; i < box.length && truckSize > 0; i++) {
            int loadBoxes = Math.min(truckSize, box[i].noOfBoxes);
            maxunits += loadBoxes * box[i].units;
            truckSize -= loadBoxes;
        }
 
        return maxunits;

    }
}