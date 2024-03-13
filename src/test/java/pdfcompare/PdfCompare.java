package pdfcompare;
import de.redsix.pdfcompare.PdfComparator;
import org.junit.Test;

import java.io.IOException;

public class PdfCompare {

    @Test
    public void pdfCompareTest() throws IOException {
        String expected ="C:\\Testing\\Expected\\Expected.pdf";
        String actual ="C:\\Testing\\Testings\\actual.pdf";
        String reportArea ="C:\\Testing\\Reports";
        boolean isEquals = new PdfComparator(expected, actual).compare().writeTo(reportArea);
        if (!isEquals) {
            System.out.println("Differences found!");
        }else {
            System.out.println("Equals");
        }
    }
}
