package com.shinhan.day07.Ch8_LAB;

public class Radio implements Volume{
	int volLevel;

	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println(getClass().getSimpleName()+"볼륨 올립니다. "+volLevel);
	}

	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println(getClass().getSimpleName()+"볼륨 내립니다. "+volLevel);
	}

}