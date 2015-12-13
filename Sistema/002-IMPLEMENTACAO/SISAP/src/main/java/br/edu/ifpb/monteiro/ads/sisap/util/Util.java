package br.edu.ifpb.monteiro.ads.sisap.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.collection.internal.PersistentBag;

public class Util {

	public static Date getDate(int ano, int mes, int dia) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.DAY_OF_MONTH, dia);

		return cal.getTime();
	}

	public static Date removeTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static <E> boolean equals(List<E> l1, List<E> l2) {
		l1 = getNotPersistentBagList(l1);
		l2 = getNotPersistentBagList(l2);
		return l1.equals(l2);
	}

	private static <E> List<E> getNotPersistentBagList(List<E> list) {
		return list instanceof PersistentBag ? new ArrayList<E>(list) : list;
	}

}
