package lambdas;

public class Demo {

    public static void main(String[] args) {
        CarSelectionView carSelectionView = new CarSelectionView();
        int userPrice = 25000;
        int lowerYearLimit = 2002;
        int upperYearLimit = 2025;

        carSelectionView.applyFilter(
                x ->{ return x.getPrice() > userPrice && x.getProducedIn() >= lowerYearLimit && x.getProducedIn() <=upperYearLimit;});
    }
}
