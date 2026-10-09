import java.util.List;

public class Main {
    record GridResult(int viewport, int columns, int gutter, int cardWidth) {}

    public static void main(String[] args) {
        List<Integer> viewports = List.of(360, 768, 1024, 1440);
        System.out.println("=== Responsive Grid Calculator ===");

        for (int viewport : viewports) {
            GridResult result = calculate(viewport);
            System.out.printf("%4dpx -> %d columns, %dpx gutter, approx. %dpx card width%n",
                    result.viewport(), result.columns(), result.gutter(), result.cardWidth());
        }
    }

    static GridResult calculate(int viewport) {
        int columns;
        int gutter;
        if (viewport < 600) {
            columns = 1;
            gutter = 16;
        } else if (viewport < 1000) {
            columns = 2;
            gutter = 20;
        } else {
            columns = 4;
            gutter = 24;
        }
        int horizontalPadding = viewport < 600 ? 32 : 64;
        int cardWidth = (viewport - horizontalPadding - gutter * (columns - 1)) / columns;
        return new GridResult(viewport, columns, gutter, cardWidth);
    }
}
