package PowerLifters.PowerLiften.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PowerLifters.PowerLiften.domein.Oefening;
import PowerLifters.PowerLiften.domein.Vragenlijst;

@Service
@Transactional
public class VragenlijstService {

	@Autowired
	VragenlijstRepository vr;
	
	public void opslaanAntwoorden(Vragenlijst v) {
		System.out.println("We got here!");
		vr.save(v);
	}
	
	public Iterable<Vragenlijst> getAllVragenlijsten() {
		Iterable<Vragenlijst> vragenlijsten = vr.findAll();
		return vragenlijsten;
	}
}
