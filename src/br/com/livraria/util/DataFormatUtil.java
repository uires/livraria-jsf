package br.com.livraria.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatUtil {

	public static Date transformStringToDate(String date) {
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyy").parse(date);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return data;
	}
}
