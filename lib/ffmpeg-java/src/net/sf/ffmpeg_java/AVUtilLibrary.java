package net.sf.ffmpeg_java;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

/**
 * Based on FFMPEG Aug 12 2007.  
 * From mem.h
 * @author Ken Larson
 *
 */
public interface AVUtilLibrary extends FFMPEGLibrary 
{
    public static final AVUtilLibrary INSTANCE = (AVUtilLibrary) Native.loadLibrary(
    		System.getProperty("os.name").startsWith("Windows") ? "avutil-49" : "avutil", 
    		AVUtilLibrary.class);

//------------------------------------------------------------------------------------------------------------------------
// mem.h
    
//    void *av_malloc(unsigned int size);
//    void *av_realloc(void *ptr, unsigned int size);
//    void av_free(void *ptr);
//    void *av_mallocz(unsigned int size);
//    char *av_strdup(const char *s);
//    void av_freep(void *ptr);
    public Pointer av_malloc(int size);
    public Pointer av_realloc(Pointer ptr, int size);
    public void av_free(Pointer ptr);
    public Pointer av_mallocz(int size);
    public Pointer av_strdup(Pointer s);
    public void av_freep(Pointer ptr);
    
// end mem.h
//------------------------------------------------------------------------------------------------------------------------
	
    
}
