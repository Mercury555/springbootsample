package ru.cbr.springboot;

import org.hibernate.JDBCException;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfDataType;
import org.jamel.dbf.structure.DbfField;
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
import java.util.Date;
import java.util.List;

import static ru.cbr.springboot.entity.Record.getNamesOfRow;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		generateDummyData(context);
		RecordRepository repository = context.getBean(RecordRepository.class);
		System.out.println(repository.findAll().size());
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
							record.setReal(dbfRow.getString("REAL"));
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
						case "DATE_CH": {
							Date date = dbfRow.getDate("DATE_CH");
							if (date.getYear() == 15893) {
								record.setDate_ch(null);
							} else {
								record.setDate_ch(date);
							}
							break;
						}
						case "VKEYDEL":
							record.setVkeydel(dbfRow.getString("VKEYDEL"));
							break;
						case "DT_IZMR": {
							Date date = dbfRow.getDate("DT_IZMR");
							if (date.getYear() == 15893) {
								record.setDt_izmr(null);
							} else {
								record.setDt_izmr(date);
							}
							break;
						}
						default:
							break;
					}
				}
				System.out.println(record.getPzn());
				record.setPzn(null);
				record.setReal(null); // чтобы обойти ограничение внешнего ключа
				record.setRgn(null);
				record.setTnp(null);
				record.setUer(null);
				repository.save(record);
				return;
				// records.add(record);
			}
		}
	}
}
