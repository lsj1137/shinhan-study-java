package com.shinhan.day07.Ch8_LAB;

public class TV implements Volume{
	int volLevel;

	@Override
	public void volumeUp(int level) {
		volLevel += level;
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
