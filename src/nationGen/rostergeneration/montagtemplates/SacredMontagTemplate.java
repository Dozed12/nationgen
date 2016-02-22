package nationGen.rostergeneration.montagtemplates;

import java.util.Random;

import nationGen.NationGen;
import nationGen.entities.Pose;
import nationGen.nation.Nation;
import nationGen.rostergeneration.SacredGenerator;
import nationGen.units.Unit;

public class SacredMontagTemplate extends MontagTemplate {
	
	public int power = 1;
	public boolean sacred = true;
	
	public Unit generateUnit(Unit u, Pose p, Nation n, NationGen ngen)
	{
		SacredGenerator sGen = new SacredGenerator(ngen, n);
		
		Random r = new Random(n.random.nextInt());
		double epicchance = r.nextDouble() * 0.5 + power * 0.25 + 0.25;
		
	    Unit newunit = null;
	    int tries = 0;
	    while(tries < 100 && newunit == null)
	    {
	    	tries++;
	    	int powernow = (int) Math.round(r.nextDouble() * (power + 2));
	    	newunit = sGen.getSacredUnit(u.race, p, powernow, sacred, epicchance);
			sGen.calculatePower(u, power);

	    }
	    
	    return newunit;
	
	}
}