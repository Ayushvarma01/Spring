package pdf;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFGenerator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File outputlocation = new File("C:\\Users\\AYUSH\\Downloads\\PDF\\Ayush_Varma_Resume.pdf");

		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		File img = new File("C:\\Users\\AYUSH\\OneDrive\\Pictures\\img\\console.png");
		PDImageXObject logo = PDImageXObject.createFromFileByContent(img, document);

		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.drawImage(logo, 2, 5);

		// Draw a side line
		contentStream.moveTo(20, 10);
		contentStream.lineTo(20, 800);
		contentStream.setStrokingColor(1, (float) 0.85, 0);
		contentStream.setLineWidth(10);
		contentStream.stroke();

		int fontSize = 12;
		float leading = 1.5f * fontSize;

		contentStream.setFont(PDType1Font.HELVETICA, fontSize);
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 700);
		contentStream.showText("TAX-O-SMART");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("123 Gorai Bridge");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Mumbai, Maharashtra 47");
		contentStream.endText();

		// Add recipient's address
		contentStream.beginText();
		contentStream.newLineAtOffset(350, 700);
		contentStream.showText("Hitesh Sah");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Malad East");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Mumbai, Maharashtra 47");
		contentStream.endText();

		// Add offer details
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 550);
		contentStream.showText("Dear Hitesh Sah,");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("We are pleased to offer you the position of [Position] with [Your Company Name].");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText(
				"Your starting salary will be $[Salary] per year, and you will begin employment on [Start Date].");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText(
				"Please review the attached documents and let us know if you have any questions or concerns.");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Sincerely,");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Rahul Jha2");
		contentStream.newLineAtOffset(0, -leading);
		contentStream.showText("Nannu");
		contentStream.endText();

		contentStream.close();

		if (outputlocation.exists()) {
			outputlocation.delete();
		}

		document.save(outputlocation.toString());
		document.close();

		System.out.println("Done");

		System.out.println("Hello pw");
	}

}