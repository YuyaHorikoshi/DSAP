package ex13;

public class HashOpenAddressing {
  private static class MyKey {
    String key;
    String data;

    public MyKey(String key, String data) {
      this.key = key;
      this.data = data;
    }
  }

  private MyKey[] table;
  private int bucketSize;
  private int n;

  private static final String REMOVED = "REMOVED";
  private static final String EMPTY = "EMPTY";
  private static final int BUCKET_SIZE = 23;

  public HashOpenAddressing() {
    this(BUCKET_SIZE);
  }
  public HashOpenAddressing(int bucketSize) {
    // ここを作る
	  table=new MyKey[bucketSize];
	  for(int i=0;i<bucketSize;i++){
		  table[i]=new MyKey(EMPTY,null);
	  }
	  this.bucketSize=bucketSize;
	  n=0;

  }
  public int hash(String key) {
    // ここを作る
	  int sum=0;
	  for(int i=0;i<key.length();i++){
		  sum+=(int)key.charAt(i);
	  }
	  return sum%bucketSize;
  }
  public int rehash(int hash) {
    // ここを作る
	  return (hash+1)%bucketSize;
  }
  public String search(String key) {
    // ここを作る
	  int c=0;
	  int h=hash(key);
	  String k;
	  while((k=table[h].key)!=EMPTY){
		  if(k!=REMOVED && key.equals(k)){
			  return table[h].data;
		  }
		  if(++c>bucketSize){
			  return null;
		  }
		  h=rehash(h);
	  }
	  return null;
  }
  public boolean add(String key, String data) {
    // ここを作る
	  int c=0;
	  int h=hash(key);
	  String k;
	  while((k=table[h].key)!=EMPTY && k!=REMOVED){
		  if(key.equals(k)){
			  return false;
		  }
		  if(++c>bucketSize){
			  throw new IllegalStateException();
			  }
			  h=rehash(h);
	  }
	  table[h].key=key;
	  table[h].data=data;
	  n++;
	  return true;
  }
  public boolean remove(String key) {
    // ここを作る
	  int c=0;
	  int h=hash(key);
	  String k;
	  while((k=table[h].key)!=EMPTY){
	  if((k!=REMOVED && key.equals(k))){ 
		  table[h].key=REMOVED;
		  table[h].data=null;
		  n--;
		  return true;
	  }
	  if(++c>bucketSize){
		  return false;
	  }
	  h=rehash(h);
	  }
	  return false;
  }
  public String toString() {
    // ここを作る
	  String s="";
	  for(int i=0;i<table.length;i++){
		  s+="bucket"+i+":";
		  String k=table[i].key;
		  if(k==EMPTY){
			  s+="EMPTY\n";
		  }else if(k==REMOVED){
			  s+="REMOVED\n";
		  }else{
			  s+="key=["+k+"] data=["+table[i].data+"]\n";
		  }
	  }
	  s+="要素の個数:"+n+"\n";
	  return s;
  }

  public static void main(String[] args) {
    HashOpenAddressing bucket = new HashOpenAddressing(11);

    bucket.add("one", "one1");
    bucket.add("two", "two2");
    bucket.add("three", "three3");
    bucket.add("four", "four4");
    bucket.add("five", "five5");
    bucket.add("six", "six6");
    bucket.add("seven", "seven7");

    System.out.println(bucket.toString());

    System.out.print("key:fiveを探索: ");
    System.out.println(bucket.search("five"));
    System.out.println();

    System.out.println("key:threeを削除");
    if (bucket.remove("three")) {
      System.out.println(bucket.toString());
    }

    System.out.print("key:threeを探索: ");
    System.out.println(bucket.search("three"));
    System.out.println();

    System.out.print("key:twoを探索: ");
    System.out.println(bucket.search("two"));
    System.out.println();

    System.out.print("key:fiveを探索: ");
    System.out.println(bucket.search("five"));
    System.out.println();

    bucket.add("eight", "eight8");
    bucket.add("nine", "nine9");
    bucket.add("ten", "ten10");

    System.out.println(bucket.toString());

    System.out.println("key:nineを削除");
    if (bucket.remove("nine")) {
      System.out.println(bucket.toString());
    }
  }
}