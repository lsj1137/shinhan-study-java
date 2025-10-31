package com.shinhan.day07.Ch8_LAB;

public class Speaker implements Volume {
	int volLevel;

	public Speaker() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void volumeUp(int level) {
		if (volLevel + level >= 100) {
			volLevel = 100;
		} else {
			volLevel += level;
		}
		System.out.println(getClass().getSimpleName()+"볼륨 올립니다. "+volLevel);
	}

	@Override
	public void volumeDown(int level) {
		if (volLevel - level <= 0) {
			volLevel = 0;
		} else {
			volLevel -= level;
		}
		System.out.println(getClass().getSimpleName()+"볼륨 내립니다. "+volLevel);
	}

}