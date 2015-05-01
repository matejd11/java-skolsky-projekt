package router;


public class SerialHelper {
    protected String    ip_address;
    protected int        mask_prefix;
    protected String    mask;
    protected boolean    no_shutdown;
    protected int    clock_rate;
    protected String name;

    public SerialHelper(String number) {
        name = "fa" + number;
    }

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public int getMask_prefix() {
		return mask_prefix;
	}

	public void setMask_prefix(int mask_prefix) {
		this.mask_prefix = mask_prefix;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public boolean isNo_shutdown() {
		return no_shutdown;
	}

	public void setNo_shutdown(boolean no_shutdown) {
		this.no_shutdown = no_shutdown;
	}

	public int getClock_rate() {
		return clock_rate;
	}

	public void setClock_rate(int clock_rate) {
		this.clock_rate = clock_rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}