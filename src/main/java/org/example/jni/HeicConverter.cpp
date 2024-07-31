#include <jni.h>
#include <de265.h>

JNIEXPORT jboolean JNICALL Java_org_example_jni_HeicConverter_convertHeicToJpeg
(JNIEnv *env, jobject obj, jstring heicFilePath, jstring jpegFilePath) {
    const char* heicPath = env->GetStringUTFChars(heicFilePath, NULL);
    const char* jpegPath = env->GetStringUTFChars(jpegFilePath, NULL);

    de265_context *ctx = de265_decoder_create();

    FILE *heicFile = fopen(heicPath, "rb");
    if (!heicFile) {
        de265_destroy(ctx);
        return JNI_FALSE;
    }

    fseek(heicFile, 0, SEEK_END);
    size_t fileSize = ftell(heicFile);
    fseek(heicFile, 0, SEEK_SET);

    uint8_t *buffer = (uint8_t *) malloc(fileSize);
    fread(buffer, 1, fileSize, heicFile);
    fclose(heicFile);

    de265_nal_unit *nal_units = de265_parse_heic(buffer, fileSize, ctx);
    de265_picture *pic = de265_decode(ctx, nal_units);

    FILE *jpegFile = fopen(jpegPath, "wb");
    if (!jpegFile) {
        free(buffer);
        de265_destroy(ctx);
        return JNI_FALSE;
    }

    de265_encode_jpeg(ctx, pic, jpegFile);

    free(buffer);
    fclose(jpegFile);
    de265_destroy(ctx);

    env->ReleaseStringUTFChars(heicFilePath, heicPath);
    env->ReleaseStringUTFChars(jpegFilePath, jpegPath);

    return JNI_TRUE;
}