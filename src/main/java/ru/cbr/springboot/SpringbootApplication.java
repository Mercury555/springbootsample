package ru.cbr.springboot;

import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfHeader;
import org.jamel.dbf.structure.DbfRow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.cbr.springboot.entity.Record;
import ru.cbr.springboot.repository.RecordRepository;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static ru.cbr.springboot.entity.Record.getNamesOfRow;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		generateDummyData(context);
	}
	private static void generateDummyData(ApplicationContext context) {
		RecordRepository repository = context.getBean(RecordRepository.class);

		{
			Path file = Paths.get("src/main/resources/BNKSEEK.DBF");
			DbfReader dbfReader = new DbfReader(file.toFile(), Charset.forName("CP866"));
			DbfHeader dbfHeader = dbfReader.getHeader();
			List<String> namesOfRow = getNamesOfRow();
			//List<Record> records = getRecords();

			for (int i = 0; i < dbfHeader.getFieldsCount(); i++) {
				namesOfRow.add(dbfHeader.getField(i).getName());
			}

			for (int j = 0; j < dbfHeader.getNumberOfRecords(); j++) {
				Record record = new Record();
				dbfReader.seekToRecord(j);
				DbfRow dbfRow = dbfReader.nextRow();
				for (int i = 0; i < dbfHeader.getFieldsCount(); i++) {
					switch (namesOfRow.get(i)) {
						case "VKEY":
							record.setVkey(dbfRow.getString("VKEY"));
							break;
						case "REAL":
							record.setReal1(dbfRow.getString("REAL"));
							break;
						case "PZN":
							record.setPzn(dbfRow.getString("PZN"));
							break;
						case "UER":
							record.setUer(dbfRow.getString("UER"));
							break;
						case "RGN":
							record.setRgn(dbfRow.getString("RGN"));
							break;
						case "IND":
							record.setInd(dbfRow.getString("IND"));
							break;
						case "TNP":
							record.setTnp(dbfRow.getString("TNP"));
							break;
						case "NNP":
							record.setNnp(dbfRow.getString("NNP"));
							break;
						case "ADR":
							record.setAdr(dbfRow.getString("ADR"));
							break;
						case "RKC":
							record.setRkc(dbfRow.getString("RKC"));
							break;
						case "NAMEP":
							record.setNamep(dbfRow.getString("NAMEP"));
							break;
						case "NAMEN":
							record.setNamen(dbfRow.getString("NAMEN"));
							break;
						case "NEWNUM":
							record.setNewnum(dbfRow.getString("NEWNUM"));
							break;
						case "NEWKS":
							record.setNewks(dbfRow.getString("NEWKS"));
							break;
						case "PERMFO":
							record.setPermfo(dbfRow.getString("PERMFO"));
							break;
						case "SROK":
							record.setSrok(dbfRow.getString("SROK"));
							break;
						case "AT1":
							record.setAt1(dbfRow.getString("AT1"));
							break;
						case "AT2":
							record.setAt2(dbfRow.getString("AT2"));
							break;
						case "TELEF":
							record.setTelef(dbfRow.getString("TELEF"));
							break;
						case "REGN":
							record.setRegn(dbfRow.getString("REGN"));
							break;
						case "OKPO":
							record.setOkpo(dbfRow.getString("OKPO"));
							break;
						case "DT_IZM":
							record.setDt_izm(dbfRow.getDate("DT_IZM"));
							break;
						case "CKS":
							record.setCks(dbfRow.getString("CKS"));
							break;
						case "KSNP":
							record.setKsnp(dbfRow.getString("KSNP"));
							break;
						case "DATE_IN":
							record.setDate_in(dbfRow.getDate("DATE_IN"));
							break;
						case "DATE_CH":
							record.setDate_ch(dbfRow.getDate("DATE_CH"));
							break;
						case "VKEYDEL":
							record.setVkeydel(dbfRow.getString("VKEYDEL"));
							break;
						case "DT_IZMR":
							record.setDt_izmr(dbfRow.getDate("DT_IZMR"));
							break;
						default:
							break;
					}
				}
				repository.save(record);
				// records.add(record);
			}
		}
	}
}
