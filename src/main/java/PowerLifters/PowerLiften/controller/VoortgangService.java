package PowerLifters.PowerLiften.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.Oefening;
import PowerLifters.PowerLiften.domein.Voortgang;

@Service
@Transactional
public class VoortgangService {

	@Autowired
	VoortgangRepository vr;
	
	@Autowired
	OefeningenRepository or;
	
	@Autowired VragenlijstRepository vlr;
	
	public double opslaanVoortgang(Voortgang v, long id) {
		System.out.println("Voortgang: " + v.getLiftaantal() + " wordt opgeslagen");
		Oefening o = or.findById(id).get();
		String a = Double.toString(v.getGebruiktegewicht());
		StringBuilder sb = new StringBuilder(a);
		sb.reverse();
		a = new String (sb);
		double b = new Double(a);
		v.setGebruiktegewicht(b);
		v.setOefening(o);
		//v.setAntwoorden(vlr.findById((long)8).get().getAntwoorden());
		vr.save(v);
		return b;
	}
	
	public void verwijderVoortgang(Long id) {
		System.out.println("Voortgang: " + id + " wordt verwijderd");
		vr.deleteById(id);
	}
	
	public Iterable<Voortgang> vindVoortgang(){
		Iterable<Voortgang> v = vr.findAll();
		return v;
	}
	
	public void geefAntwoord(String antwoord,long id) {
		vr.findById(id).get().setAntwoorden(antwoord);
	}
}
