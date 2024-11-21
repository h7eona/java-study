package tv;

public class TV {
	 private int channel;
	 private int volume;
	 private boolean power;
	 
	 public TV(int channel, int volume, boolean power) {
		 this.channel = channel;
		 this.volume = volume;
		 this.power = power;
	 }
	 
	 public int getChannel() {
		return channel;
	 }

	 public int getVolume() {
		return volume;
	 }

	public boolean isPower() {
		return power;
	}

	void power(boolean on) {
		 if (on == true){
			power = true;
		 } else {
			 power = false;
		 } 
	 }
	 
	 void volume(boolean up) {
		 if (up == true) {
			 this.volume++;
		 }
		 if (this.volume > 100) {
			 this.volume = 0;
		 }
		 else if(this.volume <= 0) {
			 this.volume = 100;
		 }
	 }
	 
	 void volume(int volume) {
		this.volume = volume;
		 if (this.volume > 100) {
			 this.volume = 0;
		 }
		 else if(this.volume <= 0) {
			 this.volume = 100;
		 }
	 }
	 
	 void channel(int channel) {
		 this.channel = channel;
		 if (this.channel > 255) {
			 this.channel = 1;
		 }
		 else if(this.channel <= 0) {
			 this.channel = 255;
		 }
	 }

	 void channel(boolean up) {
		 if (up == true) {
			 this.channel++;
		 } 
		 if (this.channel > 255) {
			 this.channel = 1;
		 }
		 else if(this.channel <= 0) {
			 this.channel = 255;
		 }
	 }
	 
	 public void status() {
		 System.out.println(
				 "TV[channel=" + channel + 
				 ", volume=" + volume + 
				 ", ßpower=" + (power ? "on" : "off") + 
				 "]");
	 }
}
