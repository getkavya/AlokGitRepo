
public class TestEncryp {

	public static void main(String[] args) throws Exception {
		
		
		String  encryptedStr = AESenc. encrypt("ALOK");
		System.out.println(encryptedStr);
		String decrypt = AESenc.decrypt(encryptedStr);
		System.out.println(decrypt);
		
		

	}

}
