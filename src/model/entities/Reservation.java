package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roombNumber;
	private Date checkIn;
	private Date checkOut;
	
	//aqui foi realziado como static porque preciso somente um, por isso, foi selecionado como static (só quero nesswe objeto)
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roombNumber, Date checkIn, Date checkOut) {
		this.roombNumber = roombNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoombNumber() {
		return roombNumber;
	}

	public void setRoombNumber(Integer roombNumber) {
		this.roombNumber = roombNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	//apagadas set check e checkout porque não quero que sejam mudadas arbitrariamente, vai ser existir um método para isso
	
	public long duration() {
		//devolve a quantidade de milissegundos da data
		long diff = checkOut.getTime() - checkIn.getTime(); // pego a data em milissegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // aqui é feito o calculo em dias com base nas duas datas
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		//fazendo receber como argumento para realizar o updateDates
	}
	
	@Override
	public String toString() {
		return
				"Room "
				+ roombNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+" nights";
		
	}
	
	
}
