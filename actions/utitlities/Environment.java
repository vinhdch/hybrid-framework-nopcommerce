package utitlities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:environmentConfig/${env}.properties" })
// @Sources({ "file:environmentConfig/dev.properties" })
public interface Environment extends Config {

	@Key("App.url")
	String appUrl();

	@Key("App.user")
	String appUsername();

	@Key("App.pass")
	String appPassword();

	@Key("DB.host")
	String appHost();

}
