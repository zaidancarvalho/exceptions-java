package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roombNumber;
	private Date checkIn;
	private Date checkOut;
	
	//aqui foi realziado como static porque preciso somente um, por isso, foi selecionado como static (só quero nesswe objeto)
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roombNumber, Date checkIn, Date checkOut){
		//se a data de checkou não for posterior a data de checkin, eu não posso aceitar também
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date") ;
		}
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
	
	public void updateDates(Date checkIn, Date checkOut) { // foi delegado a lógica de programação para a classe Reservation
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now) ) { //aqui foi realizado o tratamento da exceção personalizado
			throw new DomainException("Reservation dates for update must be future dates");
		}
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
