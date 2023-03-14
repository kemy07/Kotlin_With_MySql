import java.sql.DriverManager
import java.sql.Connection
import java.sql.Driver
import java.sql.ResultSet
import java.sql.SQLException

object Test {
    @JvmStatic
    fun connection ()
    {
        try
        {
            val c = DriverManager.getConnection(
                "jdbc:mysql://localhost/student?serverTimezone=UTC",
                "kamel07",
                "159875321"
            )
            println("Connected Successfully")
            val s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
            , ResultSet.CONCUR_UPDATABLE
            )
            val r = s.executeQuery("SELECT `id`, `firstName`, `lastName`, `city` FROM `info` WHERE 1")
            /*
            r.next()
            r.next()
            r.previous()
            r.absolute(2) // تنقلنى إلى رقم الصف مباشرة
            r.relative(-1) // بتنقلنى بالعكس لرقم الصف
            r.first() // بتنقلنى لأول صف على طول
            r.last() // بتنقلنى لآخر صف مباشرة
            r.beforeFirst() // بتنقل المؤشر لوضعة الإفتراضى
            r.afterLast() // بتنقل المؤشر لبعد الموضع الأخير
            println( r.isFirst )
            if(r.isBeforeFirst) {r.next()}
            if(r.isAfterLast) {r.previous()}
            */
            var i = 0
            while (r.next())
            {
                //i++
                i = r.row
                println( String.format(
                    "%-15s%-15s%-15s%-15s",
                    //r.row.toString() ,
                    r.getString("id"),
                    r.getString("firstName"),
                    r.getString("lastName"),
                    r.getString("city")
                ))
            }
            println("Number of Rows = $i")

        }

        catch (e:SQLException)
        {
            e.printStackTrace()
        }
    }
}