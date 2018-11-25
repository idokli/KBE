package komponenten.Spielregel.impl;

import komponenten.Spielregel.export.ISpielregel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Implementierung mit normalen Maumau-Regel + Basic Sonderregel
 */
@Service
@Qualifier("basicSonder")
public class SpielregelBasicSonderImpl extends SpielregelOhneSonderImpl implements ISpielregel {



}
