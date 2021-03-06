package PowerLifters.PowerLiften.domein;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voortgang {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToMany(mappedBy = "voortgang")
	List<Vragenlijst> vragenlijst;
	
	@ManyToOne
	private Oefening oefening;
	
	private float oefeningtijd;
	private int liftaantal;
	private double gebruiktegewicht;
	private LocalDateTime starttijd;
	
	@ManyToOne
	private GeregistreerdeSporter sporter;
	
	public List<Vragenlijst> getVragenlijst() {
		return vragenlijst;
	}
	public void setVragenlijst(List<Vragenlijst> vragenlijst) {
		this.vragenlijst = vragenlijst;
	}
	
	public GeregistreerdeSporter getSporter() {
		return sporter;
	}
	public void setSporter(GeregistreerdeSporter sporter) {
		this.sporter = sporter;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(columnDefinition = "TEXT")
	private String feedback;
	private String antwoorden;
	
	public String getAntwoorden() {
		return antwoorden;
	}
	public void setAntwoorden(String antwoorden) {
		this.antwoorden = antwoorden;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public long getId() {
		return id;
	}
	public Oefening getOefening() {
		return oefening;
	}
	public void setOefening(Oefening oefening) {
		this.oefening = oefening;
	}
	public float getOefeningtijd() {
		return oefeningtijd;
	}
	public void setOefeningtijd(float oefeningtijd) {
		this.oefeningtijd = oefeningtijd;
	}
	public int getLiftaantal() {
		return liftaantal;
	}
	public void setLiftaantal(int liftaantal) {
		this.liftaantal = liftaantal;
	}
	public double getGebruiktegewicht() {
		return gebruiktegewicht;
	}
	public void setGebruiktegewicht(double gebruiktegewicht) {
		this.gebruiktegewicht = gebruiktegewicht;
	}
	public LocalDateTime getStarttijd() {
		return starttijd;
	}
	public void setStarttijd(LocalDateTime starttijd) {
		this.starttijd = starttijd;
	}
}
