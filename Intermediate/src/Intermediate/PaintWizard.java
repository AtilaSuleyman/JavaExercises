package Intermediate;

import java.util.ArrayList;

public class PaintWizard {

    private ArrayList<Paint> paintSelection;

    public PaintWizard(){
        paintSelection = new ArrayList<>();
    }

    public static void main(String [] args){
        PaintWizard pw = new PaintWizard();
        pw.addPaints();
        pw.getCheapestPaints(200);
    }

    public void addPaints(){
        Paint first = new Paint("CheapoMax", 20, 10, 19.99);
        paintSelection.add(first);
        Paint second = new Paint("AverageJoes", 15, 11,17.99);
        paintSelection.add(second);
        Paint third = new Paint("DuluxourousPaints", 10, 20,25);
        paintSelection.add(third);
    }

    public ArrayList<Paint> getPaintSelection() {
        return paintSelection;
    }

    public void leastWastefulPaint(int roomSize) {
        int leastWaste = getOverallCoverage(getPaintSelection().get(0));
        int waste = 0;

        ArrayList<Paint> leastWastefulPaint = new ArrayList<>();

        for (Paint paint : paintSelection) {
            int totalCoverage = getOverallCoverage(paint);
            if (totalCoverage == roomSize) {
                leastWaste = waste;
                leastWastefulPaint.add(0, paint);
            } else if (totalCoverage > roomSize) {
                waste = totalCoverage - roomSize;
                if (waste < leastWaste) {
                    leastWaste = waste;
                    if (leastWastefulPaint.isEmpty()) {
                        leastWastefulPaint.add(0, paint);
                    } else {
                        leastWastefulPaint.set(0, paint);
                    }
                } else if (waste == leastWaste) {
                    leastWastefulPaint.add(paint);
                }
            } else {
                while (totalCoverage < roomSize) {
                    totalCoverage = totalCoverage + getOverallCoverage(paint);
                }
                waste = totalCoverage - roomSize;
                if (waste < leastWaste) {
                    leastWaste = waste;
                    if (leastWastefulPaint.isEmpty()) {
                        leastWastefulPaint.add(0, paint);
                    } else {
                        leastWastefulPaint.set(0, paint);
                    }
                } else if (waste == leastWaste) {
                    leastWastefulPaint.add(paint);
                }
            }
        }
        for (Paint p : leastWastefulPaint) {
            System.out.println(p);
        }
    }

    public int getOverallCoverage(Paint p){
        int coverage = 0;
        coverage = p.getCoveragePerLitre() * p.getAmountInLitres();
        return coverage;
    }

    public void getCheapestPaints(int roomSize){

        ArrayList<Paint> cheapestPaints = new ArrayList<>();
        int price = 0;
        double cheapestPaintPrice = 100000000;

        for (Paint paint:paintSelection) {
            int totalCoverage = getOverallCoverage(paint);
            if(totalCoverage == roomSize){
                if(cheapestPaints.isEmpty()){
                    cheapestPaints.add(paint);
                    cheapestPaintPrice = paint.getPrice();
                }
                else{
                    if(paint.getPrice()<cheapestPaintPrice){
                        cheapestPaints.set(0,paint);
                        cheapestPaintPrice = paint.getPrice();
                    }
                }
            }else if(totalCoverage > roomSize){
                if(paint.getPrice() < cheapestPaintPrice){
                    cheapestPaintPrice = paint.getPrice();
                    if(!cheapestPaints.isEmpty()){
                        cheapestPaints.clear();
                        cheapestPaints.add(0,paint);
                    }
                    else{
                        cheapestPaints.add(paint);
                        cheapestPaintPrice = paint.getPrice();
                    }
                }
                else if(paint.getPrice() == cheapestPaintPrice){
                    cheapestPaints.add(paint);
                }
            }
            else{
                double total = paint.getPrice();
                while(totalCoverage < roomSize){
                    totalCoverage = totalCoverage + getOverallCoverage(paint);
                    total = total + paint.getPrice();
                }
                if(total<cheapestPaintPrice){
                    cheapestPaints.clear();
                    cheapestPaints.add(paint);
                }
                else if(total==cheapestPaintPrice){
                    cheapestPaints.add(paint);
                }
            }
        }
        for (Paint p:cheapestPaints) {
            System.out.println(p);
        }
    }


}
