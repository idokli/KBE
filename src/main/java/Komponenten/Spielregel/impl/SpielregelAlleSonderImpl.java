package komponenten.Spielregel.impl;

import komponenten.Spielregel.export.ISpielregel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *  * Implementierung mit normalen Maumau-Regel + Basic Sonderregel + Alle anderen Sonderregel
 */
@Service
@Qualifier("alleSonder")
public class SpielregelAlleSonderImpl extends SpielregelBasicSonderImpl implements ISpielregel {


}
