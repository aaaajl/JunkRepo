/**
 * 
 */
package distribute.zk;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.apache.zookeeper.data.Stat;

/**
 * @author aaaajl
 *
 */
public class ZKTest {

	public static void main(String[] args) {
		
		try {
			ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 3000, null);
			byte[] b = zk.getData("/zk_test", null,null);
			System.out.println(new String(b));
			zk.create("/zk_test/fc", "ww".getBytes(), Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
			b = zk.getData("/zk_test/fc", null, null);
			Stat s = zk.exists("/zk_test/fc", false);
			System.out.println(s);
			System.out.println(new String(b));
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
